import React, {useState, useEffect} from 'react';
import { Button } from '../../components/Button';
import { ComponentMySeeds } from '../../components/ComponentMySeeds';
import { ModalNewSeed } from '../../components/ModalNewSeed';
import { Container, ContainerHeader } from './styles';
import useAuth from "../../hooks/useAuth";
import axios from 'axios';
import { url } from '../../services/url';

export function MySeeds() {
  const { token } = useAuth();

  const [openModal, setOpenModal] = useState(false);
  const [mySeedsPost, setMySeedsPost] = useState(null);

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

const initializeTryGetMySeeds = async () => {
  try {
    await tryGetMySeeds();

  } catch (error) {
    alert('ERROR!',error)
  }

}

useEffect(  ()  =>  {
    initializeTryGetMySeeds()
}, [])

  return (
    <Container>
      <ModalNewSeed refreshSeeds={() => initializeTryGetMySeeds()} valueModal={openModal} closeModal={() => setOpenModal(false)} />
      <ContainerHeader>
<h1>My seeds here</h1>
<Button onClick={() => setOpenModal(true)}  title='Add new seed' cor={'#789C32'} corTexto='#f6f7f8' />
      </ContainerHeader>

      <div>

    {
      mySeedsPost &&
        mySeedsPost?.map((data) => 
          <ComponentMySeeds
          id={data.id}
          initializeTryGetMySeeds={() => initializeTryGetMySeeds()}
          key={data.id}
          popularName={data.popularName}
          familyName={data.familyName}
          scientificName={data.scientificName}
          seedDescription={data.seedDescription}
          seedImg={data.seedImg}
          typeOfStorage={data.typeOfStorage}
          locationOfCollection={data.locationOfCollection}
          dateOfCollection={data.dateOfCollection}
           />

        )
      }

      </div>

    </Container>
  )
}