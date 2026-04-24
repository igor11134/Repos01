import { Button, Card, Layout, Typography, Space } from 'antd'

const { Header, Content, Footer } = Layout
const { Title, Paragraph } = Typography

function App() {
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
            <Button type="primary" size="large" href="/api/health" target="_blank">
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
