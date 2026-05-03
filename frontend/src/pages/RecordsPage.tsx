import { useState } from 'react'
import { api } from '../api/client'
import { useApi } from '../hooks/useApi'

export function RecordsPage({ kind }: { kind: 'customers' | 'invoices' | 'bills' }) {
  const [json, setJson] = useState('')
  const { data, loading, refresh } = useApi<any[]>(`/${kind}`)
  const save = async () => { await api.post(`/${kind}`, JSON.parse(json)); setJson(''); refresh() }

  return <section><h1 style={{ textTransform: 'capitalize' }}>{kind}</h1><p>Create record (JSON):</p><textarea value={json} onChange={e => setJson(e.target.value)} rows={7} style={{ width: '100%' }} /><button onClick={save}>Create</button><pre>{loading ? 'Loading...' : JSON.stringify(data, null, 2)}</pre></section>
}
