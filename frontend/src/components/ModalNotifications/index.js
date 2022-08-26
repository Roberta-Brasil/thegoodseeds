import React, { useState, useRef, } from 'react';
import { ref, getDownloadURL, uploadBytesResumable } from "firebase/storage";
import { storage } from '../../services/firebase'
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import { IoIosClose } from "react-icons/io";
import { TitleModal, ContainerHeader, ContainerBody, ContainerInput, FooterForm ,AvatarProfile} from './styles';
import useAuth from '../../hooks/useAuth';
import {useForm} from 'react-hook-form'
import * as Yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup'
import { url } from '../../services/url';
import axios from 'axios';

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

export function ModalNotifications({ valueModal, closeModal,  profileImg }) {
  const formRefCad = useRef(null);
  const { signout, user, setUser } = useAuth()
  const [imgURL, setImgURL] = useState("");
  const [loadingUpload, setLoadingUpload] = useState(false);
  const [handleFile, setHandleFile] = useState(null);
  const { token } = useAuth();
  
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
            <TitleModal>Notifications</TitleModal>
            <IoIosClose size={32} style={{ cursor: 'pointer' }} onClick={closeModal} />
          </ContainerHeader>

          <h1>Notifications here</h1>
          <h1>Notifications here</h1>
          <h1>Notifications here</h1>

        </Box>
      </Modal>
    </div>
  );
}
