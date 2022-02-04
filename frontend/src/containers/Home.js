import React, { useState } from 'react'
import HomeTitle from '../components/home/HomeTitle'
import { useTaskLoader } from '../hoocks/useTaskLoader'


const Home = () => {
  const { getTasks } = useTaskLoader()
  const [data, setData] = useState([])
  const [error, setError] = useState(false)

  const handleGetTaskButtonOnclick = (event) => {
    event.preventDefault()
    executeLoader()
  }

  const executeLoader = () => {
    getTasks()
      .then(response => setData(response))
      .catch(err => setError(err))
  }


  return (
    <div>
      <HomeTitle
        buttonOnclickCB={handleGetTaskButtonOnclick}
      />
    </div>
  )

}

export default Home