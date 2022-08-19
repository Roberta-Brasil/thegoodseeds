import React, { useState, useRef, useCallback, useEffect } from 'react';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm, ContainerAddSeed,  } from '../ModalNewPost/styles';
import { Button } from '../Button';

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import { TbSquarePlus } from "react-icons/tb";

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

export function ModalNewSeed({ valueModal, closeModal }) {
  const formRefCad = useRef(null);

  
  const [seedsOpen, setSeedsOpen] = useState(false);

  const [filterTypeStorage, setFilterTypeStorage] = useState([]);


  const saveForm = () => (
    alert('FINISH')
  )


  const getMySeedsById = useCallback(async (id) => {
    try {
      // const response = await api.get(
      //   `user/myseed/${id}`
      // );
      // const dataSeed  = response.data
      // setFilterTypeStorage(dataSeed)

      setFilterTypeStorage([
        {value:1, label:'family name'},
        {value:2, label:'popular name'},
        {value:3, label:'xxxx name'},
        {value:4, label:'yyy name'},
        {value:5, label:'z name'},
      ])

    
    } catch (error) {
      console.log(error);
      alert('Erro no GET')
    }
  }, []);

  function fillTypeStorage(flag) {

    const findStorage = filterTypeStorage.find(
      storage => storage.value == flag
    );

    console.log(findStorage)

    // return findStorage.label;
  }

  const searchSeeds = () => {

    const idUser = '123'

    getMySeedsById(idUser)
    setSeedsOpen(!seedsOpen)

    }

  
  const loginUserFormSchema = Yup.object().shape({
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
      {resolver: yupResolver(loginUserFormSchema)}
     )

     const submitForm = (data) => {
      console.log(data)
  
      // sendToApi(data)
      
    }


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
            <TitleModal>Create new seed</TitleModal>
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={closeModal} />
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
                {/* {errors.seedImg && <span>{errors.seedImg?.message}</span>} */}

              </ContainerInput>


              <ContainerInput>
                <label htmlFor="seed">Select a storage</label>
      <ContainerAddSeed>

<select
disabled={!seedsOpen}
id="typeOfStorage"
placeholder="Select a storage"
{...register('typeOfStorage')}
name='typeOfStorage'
>
    {
      filterTypeStorage.map((data) => 
       <option key={data.value} >{data.label}</option>
      )
    }
  </select>
                <TbSquarePlus onClick={() => searchSeeds()} color='#395908' size={32} style={{ cursor:'pointer' }} />

                </ContainerAddSeed>
                {errors.typeOfStorage && <span>{errors.typeOfStorage?.message}</span> }
                
              </ContainerInput>


              <ContainerInput>
                <label htmlFor="descricao">Location Of Collection</label>
                <input
id="locationOfCollection"

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
        placeholder="dd-mm-yyyy" 
{...register('dateOfCollection')}

        />
                {errors.dateOfCollection && <span>{errors.dateOfCollection?.message}</span> }

              </ContainerInput>

<FooterForm>
              <Button onClick={closeModal} cor='#EB5353' altura={40} title='Cancel' />
              <Button Type='submit' cor='#1FAD66' altura={40} title='Save' />

</FooterForm>

            </form>

          </ContainerBody>
        </Box>
      </Modal>
    </div>
  );
}
