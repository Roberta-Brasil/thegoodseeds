import React, {useState} from 'react';
import { IoMdTrash } from "react-icons/io";
import { BsPencilSquare } from "react-icons/bs";
import { Container, Header, TitleHeader, ButtonIcon , ButtonsActionContainer,SubContainer ,  ContainerStarButton,SubContainerPostInside, ComponentPostInside, ImageComponent, ImageUser} from './styles';
import { ModalEditSeed } from '../ModalEditSeed';
import { format } from 'date-fns';

import axios from 'axios';
import { url } from '../../services/url';
import useAuth from "../../hooks/useAuth";


export function ComponentMySeeds({
  id,
  initializeTryGetMySeeds,
  popularName,
  familyName,
  scientificName,
  seedDescription,
  seedImg,
  typeOfStorage,
  locationOfCollection,
  dateOfCollection
}) {

  const [openModal, setOpenModal] = useState(false);
  const { token } = useAuth();

  async function deleteSeed() {

    const newApi = axios.create( {
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})

   await newApi.delete(`/seeds/${id}`)
   .then((data) => 
   {
     console.log(data) 
     alert('The seed was deleted succssefully!')
     initializeTryGetMySeeds()

   }).catch((error) => {
    alert(error)
   })

 }

  const deleteItem = () => (
    deleteSeed()
  )

  const editItem = () => (
    setOpenModal(true)
  )

  return (
  <Container>
      <ModalEditSeed 
      id={id}
      refreshSeeds={initializeTryGetMySeeds}
      popularName={popularName}
      familyName={familyName}
      scientificName={scientificName}
      seedDescription={seedDescription}
      seedImg={seedImg}
      typeOfStorage={typeOfStorage}
      locationOfCollection={locationOfCollection}
      dateOfCollection={dateOfCollection}
      valueModal={openModal} closeModal={() => setOpenModal(false)} />

    <SubContainer>

    <ComponentPostInside>

    <ImageComponent src={seedImg}  />

      <div  style={{ flexDirection:'column' , display:'flex',  width:'100%', paddingLeft:8, paddingRight:8, gap:8}} >

      <TitleHeader>Popular Name: {popularName}</TitleHeader>
      <TitleHeader>Family Name: {familyName}</TitleHeader>
      <TitleHeader>Scrientific Name: {scientificName}</TitleHeader>
      <TitleHeader>Description: {seedDescription}</TitleHeader>
      <TitleHeader>Type Storage: {typeOfStorage}</TitleHeader>
      <TitleHeader>Location Collection: {locationOfCollection}</TitleHeader>
      <TitleHeader>Date Collection: {format(new Date(dateOfCollection), 'dd/MM/yyyy')}</TitleHeader>

      </div>

<ButtonsActionContainer>

  <IoMdTrash  style={{ cursor: 'pointer' }}  onClick={deleteItem} size={24} color='#EB5353' />

  <BsPencilSquare  style={{ cursor: 'pointer' }}  onClick={editItem} size={20} color='#172601' />

</ButtonsActionContainer>

    </ComponentPostInside>

    </SubContainer>

  </Container>
  )
}