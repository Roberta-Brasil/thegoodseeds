import React,{ useState, useEffect } from 'react';
import { Container, ContainerSearchBar ,FilterContainer,ContainerHeader } from './styles';
import {Button} from '../../components/Button'
import { ComponentPost  } from '../../components/ComponentPost';
import { ModalNewPost } from '../../components/ModalNewPost';
import useAuth from "../../hooks/useAuth";
import axios from 'axios';

import { url } from '../../services/url';

export function Dashboard() {
  const { token } = useAuth();

  const [searchBar, setSearchBar] = useState("");
  const [openModal, setOpenModal] = useState(false);
  const [postsDashboard, setPostsDashboard] = useState(null);

  const filterSeeds = [
    {value:1, label:'popular name'},
    // {value:2, label:'family name'},
    // {value:3, label:'scientific name'},
    // {value:4, label:'type of storage'},
    // {value:5, label:'date of collection'},
  ]


    async function tryGetAllPosts() {

      const newApi = axios.create( {
        baseURL: url,
        headers: {
          Authorization: `Bearer ${token}`,
          "Access-Control-Allow-Origin": "*",

        }})

     await newApi.get(`/posts`)
     .then((data) => 
     {
       console.log(data) 
       setPostsDashboard(data.data)

     }).catch((error) => {
      alert(error)
     })
 
   }

   const initializeTryGetAllPosts = async () => {
    try {
      await tryGetAllPosts();

    } catch (error) {
      alert('ERROR!',error)
    }

  }


  useEffect(  ()  =>  {
      initializeTryGetAllPosts()
   
  }, [])

  async function searchFilter() {

    const newApi = axios.create({
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})   

      await newApi.get(`/posts?seedPopularName=${searchBar}`)
      .then((data) => {
        console.log(data.data)
       setPostsDashboard(data.data)


      }).catch ((error) => {
        console.log('error: catch da funcao trySendNewComment ' +error)
        alert('error: catch da funcao trySendNewComment ' +error)
      }) 

    }

  return (
    <Container>
      <ModalNewPost refreshPosts={() => initializeTryGetAllPosts()} valueModal={openModal} closeModal={() => setOpenModal(false)} />

<ContainerHeader>
<h1>Welcome Seed Bird </h1>
<Button onClick={() => setOpenModal(true)}  title='Add new post' cor={'#789C32'} corTexto='#f6f7f8' />
   
      </ContainerHeader>

      <div>
      <ContainerSearchBar>

<div>
<p>Search</p>
<input
          type='search'
          placeholder="Seeds"
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

<Button onClick={() => searchFilter()}  title='Search' cor={'#789C32'} corTexto='#FFF' />

      </ContainerSearchBar>

      </div>

      {
        postsDashboard &&
        postsDashboard?.map((data) => 
          <ComponentPost
          refreshPosts={() => initializeTryGetAllPosts()} 
          key={data.postId}
          data={data}
         
           />

        )
      }

    </Container>
  )
}