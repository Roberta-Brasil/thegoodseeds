import styled from 'styled-components';


export const Container = styled.div`
width:100% ;
justify-content:center ;
display:flex ;


`;

export const FooterForm = styled.div`
width:100% ;
display:flex ;
justify-content:flex-end;

button + button {
  margin-left:  16px;
}
`;



export const ContainerHeader = styled.div`
width:100% ;
display:flex ;
align-items:center ;
justify-content:space-between ;
border-bottom: 1px solid var(--primary) ;
margin-bottom:0.5rem 
`;

export const ContainerInput = styled.div`
width:100% ;
flex-direction:column ;
display:flex ;

margin: 1rem 0;

span{
  color:red;
  font-size: 12px;
  font-weight: 600;
  letter-spacing: 2px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

}



input {
  outline: none;
  padding: 8px 20px;
  border-radius: 5px;
  font-size: 16px;
  background-color: #e5e6e7;
  border: none;
}
`;

export const ContainerEditInput = styled.div`
width:100% ;
flex-direction:column ;
display:flex ;

margin: 1rem 0;

span{
  color:red;
  font-size: 12px;
  font-weight: 600;
  letter-spacing: 2px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

}

div {
flex-direction:row ;
width:100% ;
align-items:center ;
display:flex ;

}

input {
  outline: none;
  padding: 8px 20px;
  width:100% ;
  border-radius: 5px;
  font-size: 16px;
  background-color: #e5e6e7;
  border: none;
}


`;





export const ContainerBody = styled.div`
width:100% ;
max-height:300px ;
min-height:100px ;
display:flex;



`;


export const TitleModal = styled.p`
  margin: 0.3rem 0;
  font-size: 16px;
  font-weight: 600;
  letter-spacing: 3px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

`;


