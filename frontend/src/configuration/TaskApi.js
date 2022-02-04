import axios from 'axios'
import { API_URL } from '../utils/constants'

const axiosOptions = {
  baseURL: API_URL
}

export default axios.create(axiosOptions)