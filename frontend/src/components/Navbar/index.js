import React, {useState} from 'react';
import { Container, NavBarListContainer , TitleList, SubContainer, ContainerListTitle} from './styles';
import { Link } from 'react-router-dom';
import { Avatar } from '../Avatar';
import { ModalProfile } from '../ModalProfile';
import { MdNotificationsNone, MdNotificationsActive } from "react-icons/md";
import { ModalNotifications } from '../ModalNotifications';

export function Navbar() {

  const [openModal, setOpenModal] = useState(false);
  const [openModalNotifications, setOpenModalNotifications] = useState(false);

  const viewNotifications = () => {
    setOpenModalNotifications(true)
  }

  return (
    <>
    
    <ModalNotifications  closeModal={() => setOpenModalNotifications(false)}  valueModal={openModalNotifications}/>
    <ModalProfile  closeModal={() => setOpenModal(false)}  valueModal={openModal}/>
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

<div style={{ flexDirection:'row', alignItems:'center', display:'flex', }} >
<MdNotificationsNone onClick={viewNotifications}   style={{  marginRight:8, cursor:'pointer' }} size={28} color='#e5e6e7' />
<Avatar onClick={() => setOpenModal(true)} />

</div>

      </SubContainer>

    </NavBarListContainer>
      <div style={{ height:100 }} />
      </>
  )
}