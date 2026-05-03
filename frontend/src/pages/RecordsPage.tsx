import { useState } from 'react'
import { api } from '../api/client'
import { useApi } from '../hooks/useApi'

const templates: Record<string, string> = {
  customers: '{"name":"Acme Corp","email":"finance@acme.com","currency":"USD","paymentTerms":"Net 30"}',
  invoices: '{"customerName":"Acme Corp","invoiceNumber":"INV-2026-010","amount":2500,"issueDate":"2026-05-03","dueDate":"2026-05-30","status":"SENT"}',
  bills: '{"vendor":"AWS","billNumber":"BILL-210","amount":1200,"dueDate":"2026-05-20","paid":false}'
}

export function RecordsPage({ kind }: { kind: 'customers' | 'invoices' | 'bills' }) {
  const [json, setJson] = useState(templates[kind])
  const { data, loading, refresh } = useApi<any[]>(`/${kind}`)
  const save = async () => { await api.post(`/${kind}`, JSON.parse(json)); refresh() }

  return <section><h1 style={{ textTransform: 'capitalize' }}>{kind}</h1>
    <div className='grid-2'>
      <article className='panel'><h3>Create {kind.slice(0, -1)}</h3><textarea value={json} onChange={e => setJson(e.target.value)} rows={10}/><button onClick={save}>Create</button></article>
      <article className='panel'><h3>{kind} list</h3><pre>{loading ? 'Loading...' : JSON.stringify(data, null, 2)}</pre></article>
    </div>
  </section>
}
