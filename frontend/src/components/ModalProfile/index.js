import React, { useState, useRef, useCallback, useEffect } from 'react';
import { FormHandles } from '@unform/core';
import { Form } from '@unform/web';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm ,AvatarProfile} from './styles';
import { Button } from '../Button';
import useAuth from '../../hooks/useAuth';

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

export function ModalProfile({ valueModal, closeModal, profileImg = 'https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350' }) {
  const formRefCad = useRef(null);
  const { signout } = useAuth()

  const logout = () => (
    signout()
  )

  const changeProfilePhoto = () => (
    alert('CHANGE PROFILE PHOTO')
  )

  

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
            <TitleModal>Your Profile</TitleModal>
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={closeModal} />
          </ContainerHeader>

          <AvatarProfile
          onClick={changeProfilePhoto}
    src={profileImg}
          
          />

          <ContainerInput>
          <label htmlFor="descricao">Name</label>
          <input
          value="Usuário"
          type="text"
          name="name"
          placeholder="name"
          />
          </ContainerInput>

                  <ContainerInput>
          <label htmlFor="descricao">Email</label>

          <input  
          value="User@mail.com"
                  type="email"
                  name="email"
                  placeholder="email"
                  />
                  </ContainerInput>


              <ContainerInput>
          <label htmlFor="descricao">FUll Name</label>
          <input
          value=""
          type="text"
          name="fullName"
          placeholder="fullName"
          />
          </ContainerInput>

          <ContainerInput>
          <label htmlFor="descricao">Address</label>
          <input
          value=""
          type="text"
          name="userAddress"
          placeholder="userAddress"
          />
          </ContainerInput>

          
          <ContainerInput>
          <label htmlFor="descricao">Phone Number</label>
          <input
          value=""
          type="text"
          name="phoneNumber"
          placeholder="phoneNumber"
          />
          </ContainerInput>

          <Button onClick={logout} cor='#EB5353' altura={40} title='Logout' />


          


        </Box>
      </Modal>
    </div>
  );
}
