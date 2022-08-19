import styled from 'styled-components';

export const Container = styled.div`
  width:590px ;
  border-radius:4px ;
  background-color:var(--secondary-light) ;
  display:flex;
  margin: 8px 0;
  border: solid 1px var(--primary);

`;

export const SubContainer = styled.div`
  width:100% ;
  align-items:center ;
  flex-direction:column ;
  display:flex;
  margin: 10px;

`;


export const Header = styled.div`
  width:550px;
  height:40px ;
  background-color:var(--clean);
  align-items:center ;
  flex-direction:row ;
  display:flex;
  justify-content:space-between;
  border: solid 1px var(--secondary);
border-radius:4px ;

padding:0 8px ;

div{
  flex-direction:column ;

}
`;

export const ButtonIcon = styled.div`
  cursor: pointer;
  height: ${(props) => props.size ?props.size : 14}px;
  width: ${(props) =>props.size ?props.size : 14}px;

`

export const TitleComments = styled.p`
  font-size: 12px;
  font-weight: 600;
  color:#FFF;
  letter-spacing: 1.5px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`;

export const TitleHeader = styled.p`
  margin: 0.2rem 0;
  font-size: 14px;
  font-weight: 600;
  letter-spacing: 3px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`;
export const ImageComponent = styled.img`
width:120px ;
height:80px ;
background-color:var(--light) ;
margin-right:16px;
border-radius:4px ;
`;

export const ImageUser = styled.img`
width:28px ;
height:28px ;
background-color:var(--light) ;
border-radius:50px ;
`;


export const ComponentPostInside = styled.div`
  width:550px;
  background-color:var(--clean) ;
  flex-direction:row ;
  display:flex;
  border: solid 1px var(--secondary);
  border-radius:4px ;
  padding:8px ;
  margin:8px 0 ;
`;


export const SubContainerPostInside = styled.div`
 
`;


export const ContainerStarButton = styled.div`
 flex-direction:row ;
 display:flex;
 background-color:red ;
 align-items:center ;
 justify-content:center ;
 width:100px ;
`;







