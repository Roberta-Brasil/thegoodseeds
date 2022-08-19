import React, {useState} from 'react';
import { BsStar } from "react-icons/bs";
import { Button } from '../Button';
import { GoCommentDiscussion } from "react-icons/go";
import { Container, Header, TitleHeader, ButtonIcon ,SubContainer ,  TitleComments, ContainerStarButton,SubContainerPostInside, ComponentPostInside, ImageComponent, ImageUser} from './styles';


export function ComponentPost({
  user = 'example', 
  titleSeed='titleSeed', 
  descriptionHeader= 'example', 
  imgUser, 
  ratingStar = 0 , 
  dateSeed='01/01/2012'
}) {

  const [valueStar, setValueStar] = useState(ratingStar);
  const [seedSwaped, setSeedSwaped] = useState(false);
  const [onlyRating, setOnlyRating] = useState(false);
  const [dropDownComments, setDropDownComments] = useState(false);

  
  const favoriteItem = () => {
    setOnlyRating(!onlyRating)
    if(!onlyRating){
      setValueStar(valueStar +1)
    }else{
      setValueStar(valueStar -1)
    }
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
 src={imgUser}
  />

<div>
      <TitleHeader>User: {user}</TitleHeader>
</div>

<div style={{ flexDirection:'row', display:'flex', alignItems:'center' }} >
<p style={{ paddingRight:4 }} >{valueStar}</p>

{

!onlyRatingR

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

      <TitleHeader>Title: {titleSeed}</TitleHeader>
      <TitleHeader>Description: {descriptionHeader}</TitleHeader>
      <TitleHeader>Date: {dateSeed}</TitleHeader>

    {/* AREA DOS COMENTARIOS */}
{
  dropDownComments &&
  <div style={{ margin:'8px 0px' }} >
    <hr style={{ width:'100%', margin:'8px 0px' }} />

  <h3>COMENTARIOS</h3>  
  <h3>COMENTARIOS</h3>  
  <h3>COMENTARIOS</h3>  
  <h3>COMENTARIOS</h3>  
  </div> 
  }
{/* AREA DOS COMENTARIOS */}

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