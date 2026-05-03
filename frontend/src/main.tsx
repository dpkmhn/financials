import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { AppShell } from './layout/AppShell'
import { DashboardPage } from './pages/DashboardPage'
import { RecordsPage } from './pages/RecordsPage'
import './styles.css'

function App() {
  return <BrowserRouter><AppShell><Routes><Route path='/' element={<DashboardPage />} /><Route path='/customers' element={<RecordsPage kind='customers' />} /><Route path='/invoices' element={<RecordsPage kind='invoices' />} /><Route path='/bills' element={<RecordsPage kind='bills' />} /></Routes></AppShell></BrowserRouter>
}

ReactDOM.createRoot(document.getElementById('root')!).render(<App />)
