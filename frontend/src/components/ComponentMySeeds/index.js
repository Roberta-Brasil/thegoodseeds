import React, {useState} from 'react';
import { IoMdTrash } from "react-icons/io";
import { BsPencilSquare } from "react-icons/bs";
import { Container, Header, TitleHeader, ButtonIcon , ButtonsActionContainer,SubContainer ,  ContainerStarButton,SubContainerPostInside, ComponentPostInside, ImageComponent, ImageUser} from './styles';
import { ModalEditSeed } from '../ModalEditSeed';
export function ComponentMySeeds({
  popularName,
  familyName,
  scientificName,
  seedDescription,
  seedImage,
  typeOfStorage,
  locationOfCollection,
  dateOfCollection
}) {

  const [openModal, setOpenModal] = useState(false);

  const deleteItem = () => (
    alert('Delete Item')
  )

  const editItem = () => (
    setOpenModal(true)
  )

  return (
  <Container>
      <ModalEditSeed 
      popularName={popularName}
      familyName={familyName}
      scientificName={scientificName}
      seedDescription={seedDescription}
      seedImage={seedImage}
      typeOfStorage={typeOfStorage}
      locationOfCollection={locationOfCollection}
      dateOfCollection={dateOfCollection}
      valueModal={openModal} closeModal={() => setOpenModal(false)} />

    <SubContainer>

    <ComponentPostInside>

    <ImageComponent src={seedImage}  />

      <div  style={{ flexDirection:'column' , display:'flex',  width:'100%', paddingLeft:8, paddingRight:8, gap:8}} >

      <TitleHeader>Popular Name: {popularName}</TitleHeader>
      <TitleHeader>Family Name: {familyName}</TitleHeader>
      <TitleHeader>Scrientific Name: {scientificName}</TitleHeader>
      <TitleHeader>Description: {seedDescription}</TitleHeader>
      <TitleHeader>Type Storage: {typeOfStorage}</TitleHeader>
      <TitleHeader>Location Collection: {locationOfCollection}</TitleHeader>
      <TitleHeader>Date Collection: {dateOfCollection}</TitleHeader>
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