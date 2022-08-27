import React, { useState, useRef,  useEffect } from 'react';
import { ref, getDownloadURL, uploadBytesResumable } from "firebase/storage";
import { storage } from '../../services/firebase'
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerInput, FooterForm ,AvatarProfile} from './styles';
import { Button } from '../Button';
import useAuth from '../../hooks/useAuth';
import {useForm} from 'react-hook-form'
import * as Yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup'
import { url } from '../../services/url';
import axios from 'axios';
import { Box, Modal } from '@mui/material';
import { TailSpin } from "react-loader-spinner";


const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 600,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 2,
};


export function ModalProfile({ valueModal, closeModal,  profileImg }) {
  const formRefCad = useRef(null);
  const { signout, user, setUser } = useAuth()
  const [imgURL, setImgURL] = useState("");
  const [loadingUpload, setLoadingUpload] = useState(false);
  const [handleFile, setHandleFile] = useState(null);
  const [loadingScreen, setLoadingScreen] = useState(false);
  

  const { token } = useAuth();

const formSchema = Yup.object().shape({
  name: Yup.string().required(
    'name é obrigatório.'
  ),
  email: Yup.string().required(
    'email é obrigatório.'
  ),

})


const handleClick = event => {
  formRefCad.current.click();
};

  const { 
    register, 
  handleSubmit,
  watch,
  reset,
   formState: {errors}
   } = useForm(
    {resolver: yupResolver(formSchema)}
   )

  const logout = () => (
    signout()
  )

  async function getDatasProfileFromApi() {

    const newApi = axios.create({
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})   

    await newApi.get(`/users/myprofile`)
    .then((res) => 
    {
      setUser(res.data)
     alert('The profile was updated with success!')
    setLoadingScreen(false)



    }).catch ((error)=>  {
      alert('ERROR!',error)
    setLoadingScreen(false)

    })

  }

  async function tryEditProfile(data, downloadURL) {



    const newApi = axios.create({
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})   

      await newApi.put(`/users`, {

        name:data.name,
        email:data.email,
        fullName:data.fullName,
        profileImg: downloadURL ? downloadURL : data.profileImg,
        phoneNumber:data.phoneNumber,

      })
      .then((data) => {
        

        console.log(data)

        setLoadingUpload(false)
        getDatasProfileFromApi()


      }).catch ((error) => {
        console.log('error: catch da funcao tryEditProfile ' +error)
        alert('error: catch da funcao tryEditProfile ' +error)
    setLoadingScreen(false)
    

      }) 

    }


  const handleSendImageToFirebase = (file, data) => {
    setLoadingUpload(true)
    if (!file ) {
      tryEditProfile(data, file);

      return;
    }

    const storageRef =  ref(storage, `images/${file.name}`);
     const uploadTask  = uploadBytesResumable(storageRef, file);

    uploadTask.on(
      "state_changed",
      (snapshot)  => {
        const progress = Math.round(
          (snapshot.bytesTransferred / snapshot.totalBytes) * 100
        );
      },
      (error) => {
        alert(error);
      },
      () =>   {
        getDownloadURL(uploadTask.snapshot.ref)
        .then((downloadURL)  =>  {
          console.log(downloadURL)
           setImgURL(downloadURL);
           tryEditProfile(data, downloadURL);

        }).catch((error) => {
          alert(error)
    setLoadingScreen(false)

          
        }).finally(() => {
          setLoadingUpload(false)

        })
      }
    );
  };


  const submitForm = async  (data) => {
    try {
    setLoadingScreen(true)

    handleSendImageToFirebase(handleFile, data)

    } catch (error) {
      alert('ERROR!',error)
    setLoadingScreen(false)

    }
    
  }


    useEffect(() => {

      const fillProfile = {
        name:user.name,
        email:user.email,
        fullName:user.fullName,
        profileImg:user.profileImg,
        phoneNumber:user.phoneNumber,

      };
      reset(fillProfile);

    }, [valueModal == true])

    const handleChange = (event) => {
      setHandleFile(event.target.files[0]);
    };
  

  return (
    <div>
      <Modal
        open={valueModal}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <ContainerHeader>
            <div style={{ width: 32 }} />
            <TitleModal>Your Profile</TitleModal>

            {!loadingScreen ?
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={closeModal} />

            :<IoIosClose size={32} style={{ cursor: 'default' }} disabled={true} />}
          </ContainerHeader>


          {
            !loadingScreen

            ?

          <AvatarProfile
          onClick={handleClick}
    src={user?.profileImg}
          />
        
        :

        <div style={{  width:'100%', display:'flex', marginLeft:16, height:80,width:80, alignItems:'center' }} >

        <TailSpin
          height="32"
          width="32"
          color="#4fa94d"
          ariaLabel="tail-spin-loading"
          radius="1"
          wrapperStyle={{ }}
          wrapperClass=""
          visible={true}
        />
        </div>
        
        
        }



      <input
        type="file"
        ref={formRefCad}
        onChange={handleChange}
        style={{display: 'none'}} 
      />

<form
        onSubmit={handleSubmit(submitForm)}
              style={{ width: '100%', overflow: 'scroll', overflowX: 'hidden', padding:'4px 8px' }}>


          <ContainerInput>
          <label htmlFor="descricao">Name</label>

<input
                      id="name"
                      type="text"
                      placeholder="Your name"
                      {...register('name')}
                      name='name'
                    />
          </ContainerInput>

                  <ContainerInput>
          <label htmlFor="descricao">Email</label>


<input
                      id="email"
                      type="email"
                      placeholder="Your email"
                      {...register('email')}
                      name='email'
                    />
                  </ContainerInput>


              <ContainerInput>
          <label htmlFor="descricao">Full Name</label>
<input
                      id="fullName"
                      type="text"
                      placeholder="Your fullName"
                      {...register('fullName')}
                      name='fullName'
                    />
          </ContainerInput>

          <ContainerInput>
          <label htmlFor="descricao">Phone Number</label>
<input
                      id="phoneNumber"
                      type="number"
                      placeholder="Your phoneNumber"
                      {...register('phoneNumber')}
                      name='phoneNumber'
                    />
          </ContainerInput>

          <FooterForm>

          { !loadingScreen && <Button onClick={logout} cor='#EB5353' altura={40} title='Logout' />}


            {
            !loadingScreen
              ?
          
          <Button Type="submit"  cor='#1FAD66' altura={40} title='Update' />
          
          :

          <div style={{  width:'100%', justifyContent:'flex-end', display:'flex', height:40, alignItems:'center', marginRight:16 }} >

          <TailSpin
            height="32"
            width="32"
            color="#4fa94d"
            ariaLabel="tail-spin-loading"
            radius="1"
            wrapperStyle={{ }}
            wrapperClass=""
            visible={true}
          />
          </div>

            }
          
          
          </FooterForm>
          </form>

        </Box>
      </Modal>
    </div>
  );
}
