import React from 'react';
import { ImageUser, TitleHeader } from '../ComponentPost/styles';
import { Container, SubContainer, ColumnUserComment} from './styles';

export function Comment({data}) {

const {user , createdTime, commentMessage } = data


  return (
    <Container>
<SubContainer>

<ColumnUserComment>
<div  style={{ flexDirection:'row', display:'flex' }}>
       <ImageUser 
 src={user?.profileImg}
 />

<div style={{ padding:'0px 6px' }} />
      <TitleHeader style={{ color:"#f6f7f8" } } >{user?.email}</TitleHeader>
 </div>

      <TitleHeader style={{ color:"#f6f7f8", fontSize:12 }} >{createdTime}</TitleHeader>

 </ColumnUserComment>

<div style={{ padding:'2px 4px' }} >
  <div style={{ margin:'8px 0 ' }} />

 <TitleHeader style={{ color:"#f6f7f8", fontSize:12 }} >{commentMessage}</TitleHeader>
</div>

 </SubContainer>

    </Container>
    
  )
}