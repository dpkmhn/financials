import React from 'react'; import ReactDOM from 'react-dom/client';
import { BrowserRouter, NavLink, Route, Routes } from 'react-router-dom';
import { DashboardPage } from './pages/DashboardPage'; import { RecordsPage } from './pages/RecordsPage'; import './styles.css';

function App(){return <BrowserRouter><div className='app'><aside className='sidebar'><h2>Books v2</h2><nav><NavLink to='/'>Dashboard</NavLink><NavLink to='/customers'>Customers</NavLink><NavLink to='/invoices'>Invoices</NavLink><NavLink to='/bills'>Bills</NavLink></nav></aside><main className='content'><Routes><Route path='/' element={<DashboardPage/>}/><Route path='/customers' element={<RecordsPage kind='customers'/>}/><Route path='/invoices' element={<RecordsPage kind='invoices'/>}/><Route path='/bills' element={<RecordsPage kind='bills'/>}/></Routes></main></div></BrowserRouter>}
ReactDOM.createRoot(document.getElementById('root')!).render(<App />)
