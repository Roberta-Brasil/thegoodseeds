import styled from 'styled-components';

export const ContainerSearchBar = styled.div`
align-items:flex-end ;
width:100% ;
display:flex ;
flex-direction:row ;
padding-bottom: 1.5rem ;



p{
  color:var(--primary);
  margin: 0.3rem 0;
  font-size: 16px;
  font-weight: 600;
  letter-spacing: 3px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}



input {
  width: 300px;
    padding: 0 1.5rem;
    height: 3rem;
    border-radius: 0.25rem;
    border: 1px solid #d7d7d7;
    background: #e7e9ee;
    font-weight: 400;
    color: var(--text-body);
    font-size: 1rem;
    &::placeholder {
      color: var(--text-body);
    }
  
  }

  select {
    width: 100px;
    /* padding: 0 1.5rem; */
    height: 3rem;
    border-radius: 0.25rem;
    border: 1px solid #d7d7d7;
    background: #e7e9ee;
    font-weight: 400;
    color: var(--text-body);
    font-size: 1rem;
  }

`;




export const FilterContainer = styled.div`
margin: 0 1rem ;
`

export const Container = styled.div`
flex:1;
align-items:center ;
justify-content:center ;
display:flex ;
flex-direction:column ;

h1{
  color:var(--primary); 
  font-size: 32px;
  font-weight: 600;
  letter-spacing: 3px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

`;

export const ContainerHeader = styled.div`
align-items:center ;
justify-content:center ;
display:flex ;
flex-direction:row ;
padding-bottom:1.5rem ;

h1{
  font-size: 32px;
  font-weight: 600;
  letter-spacing: 3px;
  padding: 0 1rem;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
`
