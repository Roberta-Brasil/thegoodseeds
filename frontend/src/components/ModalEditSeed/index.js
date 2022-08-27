import React, { useState,  useEffect } from 'react';
import { ref, getDownloadURL, uploadBytesResumable } from "firebase/storage";
import { storage } from '../../services/firebase'
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm , } from '../ModalNewPost/styles';
import { Button } from '../Button';
import { format, } from 'date-fns';
import useAuth from "../../hooks/useAuth";
import axios from 'axios';
import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import { typeStorage } from '../../constants/typeStorage';
import { url } from '../../services/url';
import { ContainerEditInput } from './styles';
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

export function ModalEditSeed({ valueModal, closeModal,
  refreshSeeds,
  id,
popularName,
familyName,
scientificName,
seedDescription,
seedImg,
typeOfStorage,
locationOfCollection,
dateOfCollection,
}) {

  const { token } = useAuth();

  const [seedsOpen, setSeedsOpen] = useState(false);
  const [imgURL, setImgURL] = useState(seedImg);
  const [loadingUpload, setLoadingUpload] = useState(false);
  const [loadingScreen, setLoadingScreen] = useState(false);

    const handleSendImageToFirebase = (file, data) => {
      setLoadingUpload(true)
      setLoadingScreen(true)
      console.log(file)
      if (!file ) {
        tryEditNewSeed(data, file);

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
          // setPorgessPorcent(progress);
        },
        (error) => {
          alert(error);
        },
        () =>   {
          getDownloadURL(uploadTask.snapshot.ref)
          .then((downloadURL)  =>  {
            console.log(downloadURL)
             setImgURL(downloadURL);
             tryEditNewSeed(data, downloadURL);
  
          }).catch((error) => {
            alert(error)
      setLoadingScreen(false)
            
          }).finally(() => {
            setLoadingUpload(false)

          })
        }
      );
    };


  
  const formSchema = Yup.object().shape({


    popularName: Yup.string().required(
      'popularName é obrigatório.'
    ),

    scientificName: Yup.string().required(
      'scientificName é obrigatório.'
    ),
 
    familyName: Yup.string().required(
      'familyName é obrigatório.'
    ),

    seedDescription: Yup.string().required(
      'seedDescription é obrigatório.'
    ),

    typeOfStorage: Yup.string().required(
      'typeOfStorage é obrigatório.'
    ),

    locationOfCollection: Yup.string().required(
      'locationOfCollection é obrigatório.'
    ),

      dateOfCollection: Yup.string().required(
      'dateOfCollection é obrigatório.'
    ),


  })

    const { 
      register, 
    handleSubmit,
    watch,
    reset,
     formState: {errors}
     } = useForm(
      {resolver: yupResolver(formSchema)}
     )

     const close = () => {

      closeModal()
  
      reset()}

     async function tryEditNewSeed(data, downloadURL) {
      const typeOfStorageName = data.typeOfStorage

      const newApi = axios.create({
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",
        }})   

        await newApi.put(`/seeds/${id}`, {

            popularName:data.popularName,
            scientificName:data.scientificName,
            familyName:data.familyName,
            seedDescription:data.seedDescription,
            seedImg:downloadURL ? downloadURL : seedImg ,
            typeOfStorage: typeStorage.find((data) => data.label == typeOfStorageName).value ,
            locationOfCollection:data.locationOfCollection,
            dateOfCollection:format(new Date(data.dateOfCollection), 'dd/MM/yyyy')

        })
        .then((data) => {
          console.log(data)
          refreshSeeds()
          closeModal()
          setLoadingUpload(false)
      setLoadingScreen(false)


          reset()
     alert('The seed was updated succssefully!')

  
        }).catch((error) => {
          alert(error)
      setLoadingScreen(false)

          
        }).finally(() => {
          setLoadingUpload(false)
        })

  
      }

     const submitForm = async  (data) => {
      try {
      handleSendImageToFirebase(data.seedImg[0], data)

      } catch (error) {
        alert('ERROR!',error)
    setLoadingScreen(false)

      }
      
    }

    function fillTypeStorage(flag) {

      const findStorage = typeStorage.find(
        storage => storage.value == flag
      );

      console.log(findStorage)

    }

    useEffect(() => {

      const fillSeed = {
        popularName:popularName,
        familyName:familyName,
        scientificName:scientificName,
        seedDescription:seedDescription,
        typeOfStorage:fillTypeStorage(4),
        locationOfCollection:locationOfCollection,
        dateOfCollection:format(new Date(dateOfCollection), 'yyyy-MM-dd')

      };
      reset(fillSeed);

    }, [valueModal == true])

  return (
    <div>
      <Modal
        open={valueModal}
        // onClose={closeModal}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <ContainerHeader>
            <div style={{ width: 32 }} />
            <TitleModal>Edit seed XPTO</TitleModal>


            
            {!loadingScreen ?
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={() => close()} />

            :<IoIosClose size={32} style={{ cursor: 'default' }} disabled={true} />
            }
          </ContainerHeader>


          <ContainerBody>
          <form
            onSubmit={handleSubmit(submitForm)}
              style={{ width: '100%', overflow: 'scroll', overflowX: 'hidden', padding:'4px 8px' }}>


              <ContainerInput>
                <label htmlFor="descricao">Popular Name</label>
                <input
                id="popularName"
                  type="text"
                pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                  name="popularName"
                  placeholder="popularName"
                  {...register('popularName')}
                />
                {errors.popularName && <span>{errors.popularName?.message}</span>}

              </ContainerInput>

              <ContainerInput>
                <label htmlFor="descricao">Scientific Name</label>
                <input
                id="scientificName"
                  type="text"
                pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                  name="scientificName"
                  placeholder="scientificName"
                  {...register('scientificName')}

                />
                {errors.scientificName && <span>{errors.scientificName?.message}</span>}

              </ContainerInput>

              <ContainerInput>
                <label htmlFor="descricao">Family Name</label>
                <input
                id="familyName"
                pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                  type="text"
                  name="familyName"
                  placeholder="familyName"
                  {...register('familyName')}

                />
                {errors.familyName && <span>{errors.familyName?.message}</span>}

              </ContainerInput>

              <ContainerInput>
                <label htmlFor="seedDescription">Seed Description</label>
                <input
                id="seedDescription"
                  type="text"
                  name="seedDescription"
                  placeholder="seedDescription"
                  {...register('seedDescription')}

                />
                {errors.seedDescription && <span>{errors.seedDescription?.message}</span>}

              </ContainerInput>

              <ContainerEditInput>
                <label htmlFor="seedImg">Seed Image</label>
                <div>

                <img  style={{
                    width:40, height:40 ,  marginRight:8, borderRadius:4
                }}  src={seedImg} />

<input
                id="seedImg"
                  type="file"
                  name="seedImg"
                  placeholder="seed Image"
                  accept="image/*"
                  {...register('seedImg')} />

                </div>

                {errors.seedImg && <span>{errors.seedImg?.message}</span>}

              </ContainerEditInput>

              <ContainerInput>
                <label htmlFor="seed">Select a storage</label>

<select
id="typeOfStorage"
placeholder="Select a storage"
{...register('typeOfStorage')}
name='typeOfStorage'
>
    {
      typeStorage.map((data) => 
       <option key={data.value} >{data.label}</option>
      )
    }
  </select>

                {errors.typeOfStorage && <span>{errors.typeOfStorage?.message}</span> }
                
              </ContainerInput>

              <ContainerInput>
                <label htmlFor="descricao">Location Of Collection</label>
                <input
id="locationOfCollection"
pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                  type="text"
                  name="locationOfCollection"
                  placeholder="locationOfCollection"
{...register('locationOfCollection')}

                />
                {errors.locationOfCollection && <span>{errors.locationOfCollection?.message}</span> }

              </ContainerInput>

              <ContainerInput>
                <label htmlFor="descricao">Date Of Collection</label>

<input
 type="date" 
 
id="dateOfCollection"
name="dateOfCollection" 
{...register('dateOfCollection')}

        />
                {errors.dateOfCollection && <span>{errors.dateOfCollection?.message}</span> }

              </ContainerInput>

<FooterForm>


{ !loadingScreen && <Button onClick={() => close()} cor='#EB5353' altura={40} title='Cancel' />}


 
{
            !loadingScreen
              ?
          
              <Button Type='submit' cor='#1FAD66' altura={40} title='Update' />
          
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

          </ContainerBody>
        </Box>
      </Modal>
    </div>
  );
}
