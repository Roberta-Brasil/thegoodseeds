import React from 'react'

export const FormInput = ({register, error, label, id, ...inputProps}) => {
  return (<>
    <label htmlFor={id}>{label}</label>
    <input
      ref={register}
      id={id}
      {...inputProps}
    />
    {error && <div>{error.message}</div>} 
  </>)
}