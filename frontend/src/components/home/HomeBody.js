import React from 'react'
import ErrorMessage from './ErrorMessage'
import TaskContent from './taskcontent/TaskContent'

const HomeBody = (props) => {
  const { data, error } = props

  return (
    error
      ? <ErrorMessage />
      : <TaskContent data={data} />
  )

}

export default HomeBody