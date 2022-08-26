import React, { useState, useEffect } from 'react';
import { ref, getDownloadURL, uploadBytesResumable } from "firebase/storage";
import { storage } from '../../services/firebase'

import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm, ContainerAddSeed,  } from '../ModalNewPost/styles';
import { Button } from '../Button';
import axios from 'axios';
import useAuth from "../../hooks/useAuth";
import { format, } from 'date-fns';

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import { typeStorage } from '../../constants/typeStorage';
import { url } from '../../services/url';
import { SUPPORTED_FORMATS } from '../../constants/supportedFormatsImg';

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

export function ModalNewSeed({ valueModal, closeModal ,refreshSeeds}) {

  const { token } = useAuth();
  
  const [seedsOpen, setSeedsOpen] = useState(false);
  const [imgURL, setImgURL] = useState("");
  const [loadingUpload, setLoadingUpload] = useState(false);
  
  
  const handleSendImageToFirebase = (file, data) => {
    if (!file) return;

    setLoadingUpload(true)

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
           tryCreateNewSeed(data, downloadURL);

        }).catch((error) => {
          alert(error)
          setLoadingUpload(false)
          
        }).finally(() => {
          setLoadingUpload(false)
        })
      }
    );
  };

  
  const loginUserFormSchema = Yup.object().shape({
    popularName: Yup.string().required(
      'popularName is required.'
    ),

    scientificName: Yup.string().required(
      'scientificName is required.'
    ),
 
    familyName: Yup.string().required(
      'familyName is required.'
    ),

    seedDescription: Yup.string().required(
      'seedDescription is required.'
    ),

    
    seedImg: Yup.mixed()
    .required("A file is required")
    .test(
      "fileFormat",
      "A file is required with format jpg, png, jpeg",
      value => value[0] && SUPPORTED_FORMATS.includes(value[0]?.type)
    ),

    typeOfStorage: Yup.string().required(
      'typeOfStorage is required.'
    ),

    locationOfCollection: Yup.string().required(
      'locationOfCollection is required.'
    ),

      dateOfCollection: Yup.string().required(
      'dateOfCollection is required.'
    ),


  })

    const { 
      register, 
    handleSubmit,
    watch,
    reset,
     formState: {errors}
     } = useForm(
      {resolver: yupResolver(loginUserFormSchema)}
     )


  const close = () => {

    closeModal()

    reset()}
  

     async function tryCreateNewSeed(data, downloadURL) {
       const typeOfStorageName = data.typeOfStorage

      const newApi = axios.create({
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",
        }})   

        await newApi.post(`/seeds`, {

            popularName:data.popularName,
            scientificName:data.scientificName,
            familyName:data.familyName,
            seedDescription:data.seedDescription,
            seedImg:downloadURL,
            typeOfStorage: typeStorage.find((data) => data.label == typeOfStorageName).value ,
            locationOfCollection:data.locationOfCollection,
            dateOfCollection:format(new Date(data.dateOfCollection), 'dd/MM/yyyy')
        })
        .then((data) => {

          console.log(data)

          refreshSeeds()
          closeModal()
          reset()
  
        }).catch ((error) => {
          console.log('error: catch da funcao tryCreateNewSeed ' +error)
          alert('error: catch da funcao tryCreateNewSeed ' +error)
        }) 
  
      }


     const submitForm = async (data) => {

      try {
      handleSendImageToFirebase(data.seedImg[0], data)

  
      } catch (error) {
        console.log('error -----------')
        console.log(error)
        alert('ERROR!',error)
      }
      
    }


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
            <TitleModal>Create new seed</TitleModal>
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={() => close()} />
          </ContainerHeader>

          <ContainerBody>
          <form
            onSubmit={handleSubmit(submitForm)}
              style={{ width: '100%', overflow: 'scroll', overflowX: 'hidden', padding:'4px 8px' }}>


<ContainerInput>
                <label htmlFor="descricao">Popular Name</label>
                <input
                id="popularName"
pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                  type="text"
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

              <ContainerInput>
                <label htmlFor="seedImg">Seed Image</label>
                <input
                id="seedImg"
                  type="file"
                  name="seedImg"
                  placeholder="seed Image"
                  accept="image/*"
                  {...register('seedImg')}
                />
                {errors.seedImg && <span>{errors.seedImg?.message}</span>}

              </ContainerInput>


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
        placeholder="dd/mm/yyyy" 
{...register('dateOfCollection')}

        />
                {errors.dateOfCollection && <span>{errors.dateOfCollection?.message}</span> }

              </ContainerInput>

<FooterForm>
             { !loadingUpload ?

             <>
              <Button onClick={() => close()} cor='#EB5353' altura={40} title='Cancel' />
              <Button Type='submit' cor='#1FAD66' altura={40} title='Save' />
             </>

             :

             <TitleModal>Loading datas.</TitleModal>
              }

</FooterForm>

            </form>

          </ContainerBody>
        </Box>
      </Modal>
    </div>
  );
}
