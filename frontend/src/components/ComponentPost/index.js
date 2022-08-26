import React, {useState} from 'react';
import { BsStar } from "react-icons/bs";
import { Button } from '../Button';
import { GoCommentDiscussion } from "react-icons/go";
import { Container, Header, TitleHeader, ButtonIcon ,SubContainer ,  TitleComments, ContainerStarButton,SubContainerPostInside, ComponentPostInside, ImageComponent, ImageUser, InputNewComment} from './styles';
import { Comment } from '../Comment';
import { BiSend } from "react-icons/bi";
import { url } from '../../services/url';
import axios from 'axios';
import useAuth from "../../hooks/useAuth";


export function ComponentPost({
  data,
  refreshPosts
}) {

  const { token } = useAuth();

  const { comments, createdTime, likesQuantity, postId, postMessage, seed, title, user } = data

  const [valueStar, setValueStar] = useState(0);
  const [seedSwaped, setSeedSwaped] = useState(false);
  const [onlyRating, setOnlyRating] = useState(false);
  const [dropDownComments, setDropDownComments] = useState(false);
  const [writeNewComment, setWriteNewComment] = useState(null);
  
  const favoriteItem = () => {
    tryLikePosts()
  }

  async function tryLikePosts() {

    const newApi = axios.create({
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})   

      await newApi.post(`/posts/${postId}/likes`)
      .then((data) => {
        refreshPosts()

      }).catch ((error) => {
        console.log('error: catch da funcao tryLikePosts ' +error)
        alert('error: catch da funcao tryLikePosts ' +error)
      }) 

    }

  async function trySendNewComment() {

    const newApi = axios.create({
      baseURL: url,
      headers: {
        Authorization: `Bearer ${token}`,
        "Access-Control-Allow-Origin": "*",
      }})   

      await newApi.put(`/posts/${postId}/comment`, {
      message:writeNewComment
      })
      .then((data) => {
        console.log(data)
        refreshPosts()
        setWriteNewComment("")

      }).catch ((error) => {
        console.log('error: catch da funcao trySendNewComment ' +error)
        alert('error: catch da funcao trySendNewComment ' +error)
      }) 

    }

  const sendMessage = () => {
    if(!writeNewComment || writeNewComment == "") {
      console.log('not send')
      return
    }

    trySendNewComment()
  }

  

  const openComments = () => {
    setDropDownComments(!dropDownComments)
  }
  

  const swapSeeds = () => {
    setSeedSwaped(!seedSwaped)
  }

  return (
  <Container>

    <SubContainer>
    <Header>
 
 <ImageUser 
 src={user?.profileImg}
  />

<div>
      <TitleHeader>User: {user?.email}</TitleHeader>
</div>

<div style={{ flexDirection:'row', display:'flex', alignItems:'center' }} >
<p style={{ paddingRight:4 }} >{likesQuantity}</p>

{

!onlyRating

?
      <ButtonIcon onClick={favoriteItem} size={22} >
        <BsStar color='#172601' size={22} />
      </ButtonIcon> 
      :
      <ButtonIcon onClick={favoriteItem} size={22} >
      <BsStar color='#9a9b9c' size={22} />
    </ButtonIcon> 
}

</div>

    </Header>

    <ComponentPostInside>
      <div  style={{ flexDirection:'column' , display:'flex',  width:'100%', paddingLeft:8, paddingRight:8, }} >

      <div style={{  display:'flex', flexDirection:'column', }} >


<TitleHeader>Title: {title}</TitleHeader>
<TitleHeader>Post Message: {postMessage}</TitleHeader>
<TitleHeader>Date: {createdTime}</TitleHeader>

  
</div>


      <div  
      style={{
        width:80, height:80 ,  
        marginTop:12
        
      }}
      >
        
      <img  style={{
        width:80, height:80 ,   
        borderRadius:4, 
        objectFit:'cover'
      }}  src={seed?.seedImg} />
      </div>
      <TitleHeader  >Seed: {seed?.popularName}</TitleHeader>


      


    {/* AREA DOS COMENTARIOS */}
{
  dropDownComments &&
  <div style={{ margin:'8px 0px' }} >
    <hr style={{ width:'100%', margin:'8px 0px' }} />

  {
    comments &&
    comments.map((data)=> 

      <Comment data={data}/>
    )

  }

<div  style={{ width:'100%', display:'flex', marginTop:22, alignItems:'center' }}>

  <InputNewComment
          type='text'
pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ,.!?- ]*"
          
          placeholder="comment here"
          value={writeNewComment}
          onChange={event => setWriteNewComment(event.target.value)}
        />

        <BiSend onClick={sendMessage}  style={{ marginLeft:8, cursor:'pointer' }} size={32} color='#172601' />
</div>


  </div> 
  }

        <div style={{ justifyContent:'space-between', alignItems:'flex-end' ,
        display:'flex',width:'100%', height:'100%', marginTop:8 }} >

<div  onClick={openComments} style={{ cursor:'pointer',alignItems:'center', display:'flex', justifyContent:'center' , border:'solid 1px transparent ', padding:'2px 8px', borderRadius:4 , backgroundColor:'#789C32'}} >
    <GoCommentDiscussion style={{  marginRight:6 }} color="#FFF" size={20} />
    <TitleComments>{dropDownComments ? 'Hide' : 'Comments' }</TitleComments>
</div>
        
        {
!seedSwaped
?
<Button altura={28} onClick={swapSeeds}  largura={120}  title='Swap' cor='#789C32' corTexto='#FFF' />
:
<Button altura={28} onClick={swapSeeds}  largura={120}  title='Unswap' cor='#9a9b9c' corTexto='#ccc' />

        }
        </div>

      </div>

    </ComponentPostInside>

    </SubContainer>

  </Container>
  )
}