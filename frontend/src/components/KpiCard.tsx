export function KpiCard({ label, value, sub }: { label: string; value: string; sub: string }) {
  return <article className='kpi'><p className='muted'>{label}</p><h3>{value}</h3><small>{sub}</small></article>
}
