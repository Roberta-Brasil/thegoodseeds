import React,{ useState } from 'react';
import { Container, ContainerSearchBar ,FilterContainer,ContainerHeader } from './styles';
import {Button} from '../../components/Button'
import { ComponentPost  } from '../../components/ComponentPost';
import { ModalNewPost } from '../../components/ModalNewPost';

export function Dashboard() {
  const [searchBar, setSearchBar] = useState("");
  const [openModal, setOpenModal] = useState(false);

  const postsDashboard = [
    {
      id:1,
      user:'João',
      titleSeed:'Semente Guaraná',
      descriptionHeader:'plantada na amazonia XPTO',
      imgUser:'https://cdn.pixabay.com/photo/2014/03/24/17/19/teacher-295387__340.png',
      ratingStar:20,
      dateSeed:'12/05/2012'
    },
    {
      id:2,
      user:'Maria',
      titleSeed:'Semente Soja',
      descriptionHeader:'plantada na mata atlatntica XPTO',
      imgUser:'https://cdn.pixabay.com/photo/2014/03/24/17/19/teacher-295387__340.png',
      ratingStar:3,
      dateSeed:'02/01/2012'

    },
  ]

  const filterSeeds = [
    {value:1, label:'scientific name'},
    {value:2, label:'family name'},
    {value:3, label:'popular name'}
  ]

  return (
    <Container>
      <ModalNewPost valueModal={openModal} closeModal={() => setOpenModal(false)} />

<ContainerHeader>
<h1>Search our seeds here</h1>
<Button onClick={() => setOpenModal(true)}  title='Add new post' cor={'#789C32'} corTexto='#f6f7f8' />
      </ContainerHeader>

      <div>
      <ContainerSearchBar>

<div>
<p>Search</p>
<input
          type='search'
          placeholder="Seeds tomato"
          value={searchBar}
          onChange={event => setSearchBar(event.target.value)}
        />
</div>


<FilterContainer>

<p>Filter by</p>
  <select>
    {
      filterSeeds.map((data) => 
       <option key={data.value} >{data.label}</option>
      )
    }
  </select>
</FilterContainer>

<Button  title='Search' cor={'#789C32'} corTexto='#FFF' />

      </ContainerSearchBar>


      </div>

      {
        postsDashboard.map((data) => 
          <ComponentPost
          key={data.id}
           user={data.user}
           titleSeed={data.titleSeed}
           descriptionHeader={data.descriptionHeader}
           dateSeed={data.dateSeed}
           imgUser={data.imgUser}
           ratingStar={data.ratingStar}
           />

        )
      }


    </Container>
  )
}