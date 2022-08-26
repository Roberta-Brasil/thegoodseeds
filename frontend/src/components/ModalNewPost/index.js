import React, { useState, useRef, useEffect } from 'react';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm, } from './styles';
import { Button } from '../Button';
import axios from 'axios';

import * as Yup from 'yup';
import {useForm} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import useAuth from "../../hooks/useAuth";
import { url } from '../../services/url';

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

export function ModalNewPost({ valueModal, closeModal, refreshPosts }) {
  const refFormUpdate = useRef(null);
  const { token } = useAuth();

  const [filterSeeds, setFilterSeeds] = useState([]);
  const [mySeedsPost, setMySeedsPost] = useState([{}]);


  const formSchema = Yup.object().shape({
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
      {resolver: yupResolver(formSchema)}
     )


    async function tryGetMySeeds() {

      const newApi = axios.create( {
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",
        }})   
    
     await newApi
     .get(`/users/myseeds`)
     .then((res) => 
     {
       console.log(res) 
       setMySeedsPost(res.data)
    
     }).catch((error) => {
      alert(error)
     })
    
    }

     async function tryCreateNewPost(data) {
      const {

        title,
        postMessage,
        seedIdDto
      } =data

      const newApi = axios.create({
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",
        }})   

        await newApi.post(`/posts`, {
          title,
          postMessage,
          seedIdDto: {
            id:mySeedsPost?.find((data) => data.popularName == seedIdDto).id

          }
        })
        .then((data) => {

          refreshPosts()
          closeModalMethod()
  
        }).catch ((error) => {
          console.log('error: catch da funcao tryCreateNewPost ' +error)
          alert('error: catch da funcao tryCreateNewPost ' +error)
        }) 
  
      }


  const submitForm = async (data) => {
    try {
      await tryCreateNewPost(data);

    } catch (error) {
      console.log('error -----------')
      console.log(error)
      alert('ERROR!',error)
    }
    
  }

  
  const closeModalMethod = () => {
    reset();
    setMySeedsPost(null)
    closeModal()
  }


    useEffect(() => {
      if(valueModal ==true){
        tryGetMySeeds()
      }
    }, [valueModal == true])
    

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
pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"
                      id="title"
                      type="text"
                      placeholder="Your title"
                      {...register('title')}
                      name='title'
                    />
                {errors.title && <span>{errors.title?.message}</span> }
              </ContainerInput>

              <ContainerInput>
                <label htmlFor="postMessage">Post Message</label>
                <input
                      id="postMessage"
pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"

                      type="text"
                      placeholder="Your postMessage"
                      {...register('postMessage')}
                      name='postMessage'
                    />
                {errors.postMessage && <span>{errors.postMessage?.message}</span> }
              </ContainerInput>

              <ContainerInput>
                <label htmlFor="seed">Select a seed</label>

                <select
                placeholder="Select a seed"
                {...register('seedIdDto')}
                name='seedIdDto'
                >
                      <option selected value="" disabled>Choose one seed</option>

                    {
                      mySeedsPost &&
                      mySeedsPost?.map((data,index) => 
                      <option  key={index} >{data.popularName}</option>
                      )
                    }
                  </select>

                {errors.seedIdDto && <span>{errors.seedIdDto?.message}</span> }
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
