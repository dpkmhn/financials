const baseUrl = import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080/api'

async function req<T>(path: string, init?: RequestInit): Promise<T> {
  const res = await fetch(`${baseUrl}${path}`, {
    ...init,
    headers: { 'content-type': 'application/json', 'X-Org-Id': 'demo-org', ...(init?.headers || {}) }
  })
  if (!res.ok) throw new Error(await res.text())
  return res.json() as Promise<T>
}

export const api = {
  get: <T>(path: string) => req<T>(path),
  post: <T>(path: string, body: unknown) => req<T>(path, { method: 'POST', body: JSON.stringify(body) })
}

export const mock = {
  bankTransactions: [
    { id: 'txn-1', account: 'Business Checking', date: '2026-05-01', amount: 12800, type: 'CREDIT', category: 'Customer Payment' },
    { id: 'txn-2', account: 'Business Checking', date: '2026-05-02', amount: 2200, type: 'DEBIT', category: 'Cloud Infrastructure' }
  ],
  expenses: [
    { id: 'exp-1', merchant: 'Delta Airlines', amount: 480, date: '2026-05-01', category: 'Travel', status: 'APPROVED' },
    { id: 'exp-2', merchant: 'Amazon', amount: 160, date: '2026-05-03', category: 'Office', status: 'SUBMITTED' }
  ]
}
