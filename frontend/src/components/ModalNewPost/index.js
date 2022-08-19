import React, { useState, useRef, useCallback, useEffect } from 'react';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm, ContainerAddSeed } from './styles';
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

export function ModalNewPost({ valueModal, closeModal }) {
  const formRefCad = useRef(null);
  const api = "localhost.com"
  const refFormUpdate = useRef(null);

  const [seedsOpen, setSeedsOpen] = useState(false);
  const [filterSeeds, setFilterSeeds] = useState([]);

  const loginUserFormSchema = Yup.object().shape({
    title: Yup.string().required(
      'title é obrigatório.'
    ),

    postMessage: Yup.string().required(
      'postMessage é obrigatório.'
    ),

    seedIdDto: Yup.string().required(
      'seed é obrigatório.'
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


     const getMySeedsById = useCallback(async (id) => {
      try {
        // const response = await api.get(
        //   `user/myseed/${id}`
        // );
        // const dataSeed  = response.data
        // setFilterSeeds(dataSeed)

        setFilterSeeds([
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


     
  const sendToApi = useCallback(
    async (dataSeeds) => {
      try {

    const { title, postMessage, seedIdDto } = dataSeeds 

        await api.post('route-api-seed-heroku', {
          title,
          postMessage,
          seedIdDto:{id:seedIdDto}
        });

       alert('Post feito com sucesso!')
      } catch (error) {
       alert('Erro na requisição.')

      }
    },
    []
  );

  const submitForm = (data) => {
    console.log(data)

    sendToApi(data)
    
  }

  const closeModalMethod = () => {
    const resetFields = {
      title: '',
      postMessage: '',
      seedIdDto: ''
    };
    setSeedsOpen(false)
    reset(resetFields);

    closeModal()
  }

   const searchSeeds = () => {

    const idUser = '123'

    getMySeedsById(idUser)
    setSeedsOpen(!seedsOpen)

    }

    // function fillSeedDto(flag) {

    //   const findSeed = filterSeeds.find(
    //     seed => seed.value == flag
    //   );

    //   console.log(findSeed.label)
    //   return findSeed.label;
    // }

    // useEffect(() => {

    //   const fillTipoProduto = {
    //     title:' asdsdsa',
    //     postMessage: '123213',
    //     seedIdDto:fillSeedDto(2)

    //   };
    //   reset(fillTipoProduto);

    // }, [valueModal])
    

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
            <TitleModal>Create new post</TitleModal>
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={closeModalMethod} />
          </ContainerHeader>


          <ContainerBody>

            <form
          ref={refFormUpdate}
            onSubmit={handleSubmit(submitForm)}
              style={{ width: '100%', overflow: 'scroll', overflowX: 'hidden', padding:'4px 8px' }}>

              <ContainerInput>
                <label htmlFor="title">Title</label>
                <input
                      id="title"
                      type="text"
                      placeholder="Your title"
                      {...register('title')}
                      name='title'
                    />
                {errors.title && <span s>{errors.title?.message}</span> }
              </ContainerInput>

              <ContainerInput>
                <label htmlFor="postMessage">Post Message</label>
                <input
                      id="postMessage"
                      type="text"
                      placeholder="Your postMessage"
                      {...register('postMessage')}
                      name='postMessage'
                    />
                {errors.postMessage && <span s>{errors.postMessage?.message}</span> }
              </ContainerInput>

              <ContainerInput>
                <label htmlFor="seed">Select a seed</label>
      <ContainerAddSeed>

<select
disabled={!seedsOpen}
id="seedIdDto"
placeholder="Select a seed"
{...register('seedIdDto')}
name='seedIdDto'
>
    {
      filterSeeds.map((data) => 
       <option key={data.value} >{data.label}</option>
      )
    }
  </select>

                <TbSquarePlus onClick={() => searchSeeds()} color='#395908' size={32} style={{ cursor:'pointer' }} />

                </ContainerAddSeed>
                {errors.seedIdDto && <span s>{errors.seedIdDto?.message}</span> }
              </ContainerInput>

              <FooterForm>
              <Button onClick={closeModalMethod} cor='#EB5353' altura={40} title='Cancel' />
              <Button Type='submit' cor='#1FAD66' altura={40} title='Save' />
        
          </FooterForm>

            </form>

          </ContainerBody>
        </Box>
      </Modal>
    </div>
  );
}
