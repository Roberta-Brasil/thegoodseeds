import React, {useState} from 'react';
import { Container, NavBarListContainer , TitleList, SubContainer, ContainerListTitle} from './styles';
import { Link } from 'react-router-dom';
import { Avatar } from '../Avatar';
import { ModalProfile } from '../ModalProfile';


export function Navbar() {

  const [openModal, setOpenModal] = useState(false);

  return (
    <>
    <ModalProfile closeModal={() => setOpenModal(false)}  valueModal={openModal}/>
    <NavBarListContainer>
  
      <SubContainer>
      <a>The Good Seeds</a>

      <ContainerListTitle>

      <Link className="hh" to ="/dashboard">
            <TitleList href="">Dashboard</TitleList>
    </Link>

    <Link className="hh" to ="/my-seeds">
            <TitleList href="">My Seeds</TitleList>
    </Link>

    </ContainerListTitle>

<Avatar onClick={() => setOpenModal(true)} />

      </SubContainer>

    </NavBarListContainer>
      <div style={{ height:100 }} />
      </>
  )
}