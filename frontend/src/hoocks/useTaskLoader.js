import TaskApi from '../configuration/TaskApi'
import { API_URI } from '../utils/constants'

export const useTaskLoader = () => {

  const getTasks = async () => {
    try {
      const response = await TaskApi.get(API_URI)
      return response.data
    } catch (err) {
      throw new Error(err)
    }
  }

  return { getTasks }


}

