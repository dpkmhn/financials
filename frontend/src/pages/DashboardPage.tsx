import { Area, AreaChart, CartesianGrid, ResponsiveContainer, Tooltip, XAxis, YAxis } from 'recharts'
import { KpiCard } from '../components/KpiCard'
import { useApi } from '../hooks/useApi'
import type { DashboardSummary } from '../types'

const money = (n: number) => new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD', maximumFractionDigits: 0 }).format(n)

export function DashboardPage() {
  const { data } = useApi<DashboardSummary>('/dashboard')
  if (!data) return <div className='panel'>Loading dashboard...</div>

  const netCash = data.cashFlow.reduce((a, p) => a + p.incoming - p.outgoing, 0)

  return <section className='dashboard'>
    <h1>Financial Command Center</h1>
    <div className='grid-4'>
      <KpiCard label='Total Receivables' value={money(data.totalReceivables)} sub={`Overdue ${money(data.overdueReceivables)}`} />
      <KpiCard label='Total Payables' value={money(data.totalPayables)} sub={`Overdue ${money(data.overduePayables)}`} />
      <KpiCard label='Net Cash Movement' value={money(netCash)} sub='Last 3 months' />
      <KpiCard label='Collection Efficiency' value='89%' sub='Above last month by 4%' />
    </div>

    <div className='grid-2'>
      <article className='panel'><h3>Cashflow Trend</h3><ResponsiveContainer width='100%' height={260}><AreaChart data={data.cashFlow}><CartesianGrid strokeDasharray='3 3'/><XAxis dataKey='month'/><YAxis/><Tooltip/><Area type='monotone' dataKey='incoming' stroke='#2563eb' fill='#bfdbfe'/><Area type='monotone' dataKey='outgoing' stroke='#ef4444' fill='#fecaca'/></AreaChart></ResponsiveContainer></article>
      <article className='panel'><h3>Action Center</h3><ul className='actions'><li>Create invoice & share payment link</li><li>Match bank feeds against open invoices</li><li>Approve pending expenses</li><li>Review overdue receivables aging</li></ul></article>
    </div>
  </section>
}
