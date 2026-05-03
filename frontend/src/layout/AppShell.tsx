import { NavLink } from 'react-router-dom'
import { ReactNode } from 'react'

export function AppShell({ children }: { children: ReactNode }) {
  return <div className='app'><aside className='sidebar'><h2>Books v2</h2><nav><NavLink to='/'>Dashboard</NavLink><NavLink to='/customers'>Customers</NavLink><NavLink to='/invoices'>Invoices</NavLink><NavLink to='/bills'>Bills</NavLink></nav></aside><main className='content'>{children}</main></div>
}
