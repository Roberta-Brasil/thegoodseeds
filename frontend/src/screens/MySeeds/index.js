import React, {useState} from 'react';
import { Button } from '../../components/Button';
import { ComponentMySeeds } from '../../components/ComponentMySeeds';
import { ModalNewSeed } from '../../components/ModalNewSeed';
import { Container, ContainerHeader } from './styles';

export function MySeeds() {
  const [openModal, setOpenModal] = useState(false);

  const mySeedsPost = [
    {
      id:1,
      popularName:'Semente Guaraná',
      familyName:'Semente Guaraná',
      scientificName:'Semente Guaraná',
      seedDescription:'plantada na amazonia XPTO',
      seedImage:'https://thumbs.dreamstime.com/z/sementes-de-guarana-53257458.jpg',
      typeOfStorage:1,
      locationOfCollection:'Location Test',
      dateOfCollection:'01/02/2018'
    },
    {
      id:2,
      popularName:'Semente Soja',
      familyName:'Semente Guaraná',
      scientificName:'Semente Soja',
      seedDescription:'plantada na mata atlatntica XPTO',
      seedImage:'https://www.brasmaxgenetica.com.br/blog/wp-content/uploads/sites/6/2021/05/IMG-MAI_A03-1200x675.png',
      typeOfStorage:2,
      locationOfCollection:'Location Test',
      dateOfCollection:'05/02/2018'
    },
  ]

  return (
    <Container>
      <ModalNewSeed valueModal={openModal} closeModal={() => setOpenModal(false)} />
      <ContainerHeader>
<h1>My seeds here</h1>
<Button onClick={() => setOpenModal(true)}  title='Add new seed' cor={'#789C32'} corTexto='#f6f7f8' />
      </ContainerHeader>

      <div>

    {
        mySeedsPost.map((data) => 
          <ComponentMySeeds
          key={data.id}
          popularName={data.popularName}
          familyName={data.familyName}
          scientificName={data.scientificName}
          seedDescription={data.seedDescription}
          seedImage={data.seedImage}
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