import styled from 'styled-components';

export const SubContainer = styled.div`
flex-direction:row ;
width:90% ;
display:flex ;
align-items:center ;
justify-content:space-between ;

a {
  color:var(--light)
}
`;

export const NavBarListContainer = styled.nav`
width:100% ;
background-color:var(--secondary); 
justify-content:center ;
display:flex ;
position:fixed;
height:80px ;
z-index: 20;

`;

export const TitleList = styled.p`
margin: 0 16px ;
font-size:18px ;
color: var(--light);
`;

export const ContainerListTitle = styled.div`
align-items:center ;
display:flex ;
`;