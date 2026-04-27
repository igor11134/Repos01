import React, { useState } from 'react'
import { Button, Card, Layout, Typography, Space, InputNumber, Alert, Tag } from 'antd'
import { useQuery } from '@tanstack/react-query'
import { fetchCurrentUser, type UserDto } from './api/users'

const { Header, Content, Footer } = Layout
const { Title, Paragraph, Text } = Typography

function App() {
  const [userId, setUserId] = useState<number>(1)

  const { data: user, isLoading, isError, error, refetch } = useQuery<UserDto, Error>({
    queryKey: ['currentUser', userId],
    queryFn: () => fetchCurrentUser(userId),
    enabled: !!userId,
    retry: false,
    staleTime: 1000 * 60,
  })

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Header style={{ background: '#001529' }}>
        <Title style={{ color: '#fff', margin: 0, lineHeight: '64px' }} level={3}>
          НИОКР управление
        </Title>
      </Header>
      <Content style={{ padding: '40px 24px' }}>
        <Card>
          <Space direction="vertical" size="large" style={{ width: '100%' }}>
            <Title level={2}>MVP информационной системы управления НИОКР</Title>
            <Paragraph>
              Централизованное приложение для управления проектами, задачами и ресурсами НИОКР.
            </Paragraph>
            <Space direction="horizontal" align="center" size="middle">
              <Text>Тестовый X-User-Id:</Text>
              <InputNumber
                min={1}
                value={userId}
                onChange={(value) => setUserId(value ?? 1)}
              />
              <Button type="primary" onClick={() => refetch()}>
                Загрузить пользователя
              </Button>
            </Space>

            {isLoading && <Alert message="Загрузка пользователя..." type="info" showIcon />}
            {isError && (
              <Alert
                message="Ошибка при получении пользователя"
                description={error?.message ?? 'Неизвестная ошибка'}
                type="error"
                showIcon
              />
            )}

            {user && (
              <Card title="Текущий пользователь" type="inner">
                <Space direction="vertical" size="middle" style={{ width: '100%' }}>
                  <Text>
                    <b>ID:</b> {user.id}
                  </Text>
                  <Text>
                    <b>Логин:</b> {user.username}
                  </Text>
                  <Text>
                    <b>ФИО:</b> {user.fullName}
                  </Text>
                  <Space wrap>
                    {user.roles.map((role) => (
                      <Tag key={role} color="blue">
                        {role}
                      </Tag>
                    ))}
                  </Space>
                </Space>
              </Card>
            )}

            <Button type="default" size="large" href="/api/health" target="_blank">
              Проверить backend health
            </Button>
          </Space>
        </Card>
      </Content>
      <Footer style={{ textAlign: 'center' }}>NIОКР IS MVP</Footer>
    </Layout>
  )
}

export default App
