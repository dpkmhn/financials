import { useEffect, useState } from 'react'; import { api } from '../api/client';

export function RecordsPage({kind}:{kind:'customers'|'invoices'|'bills'}){ const [rows,setRows]=useState<any[]>([]); const [json,setJson]=useState('');
const load=()=>api.get<any[]>(`/${kind}`).then(setRows); useEffect(()=>{load()},[kind]);
const save=async()=>{await api.post(`/${kind}`, JSON.parse(json)); setJson(''); load()}
return <section><h1 style={{textTransform:'capitalize'}}>{kind}</h1><p>Create record (JSON):</p><textarea value={json} onChange={e=>setJson(e.target.value)} rows={7} style={{width:'100%'}} placeholder='{"name":"Acme"...}'/><button onClick={save}>Create</button><pre>{JSON.stringify(rows,null,2)}</pre></section> }
