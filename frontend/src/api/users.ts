import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? '/api'

export interface UserDto {
  id: number
  username: string
  fullName: string
  roles: string[]
}

export async function fetchCurrentUser(userId: number): Promise<UserDto> {
  const response = await axios.get<UserDto>(`${API_BASE_URL}/users/me`, {
    headers: {
      'X-User-Id': userId.toString(),
    },
  })
  return response.data
}
