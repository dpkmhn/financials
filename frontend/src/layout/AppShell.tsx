import { NavLink } from 'react-router-dom'
import { ReactNode } from 'react'

const nav = [
  ['/', 'Dashboard'], ['/customers', 'Customers'], ['/invoices', 'Invoices'], ['/bills', 'Bills'], ['/banking', 'Banking'], ['/expenses', 'Expenses'], ['/reports', 'Reports']
]

export function AppShell({ children }: { children: ReactNode }) {
  return <div className='app'>
    <aside className='sidebar'>
      <h2>LedgerFlow</h2>
      <p className='muted'>Demo Org</p>
      <nav>{nav.map(([to, label]) => <NavLink key={to} to={to}>{label}</NavLink>)}</nav>
    </aside>
    <main className='content'>
      <header className='topbar'><input placeholder='Search customers, invoices, bills...' /><div className='topbar-actions'><button>+ New</button><button className='ghost'>⚙</button></div></header>
      {children}
    </main>
  </div>
}
