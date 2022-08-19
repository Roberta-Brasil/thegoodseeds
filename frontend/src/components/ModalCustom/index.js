import React from 'react';
import Modal from "react-modal";
import { ComponentPost } from '../ComponentPost';
import "./style.css";

export function ModalCustom({valueModal, closeModal}) {
  return (
    <>
    <Modal
      isOpen={valueModal}
      // onRequestClose={closeModal}
      contentLabel="Example Modal"
      overlayClassName="modal-overlay"
      className="modal-content"
    >
    <button onClick={closeModal}>Close Modal</button>
    </Modal>
  </>
  )
}