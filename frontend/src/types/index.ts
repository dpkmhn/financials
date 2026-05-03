export type CashFlowPoint = { month: string; incoming: number; outgoing: number }
export type DashboardSummary = { totalReceivables: number; overdueReceivables: number; totalPayables: number; overduePayables: number; cashFlow: CashFlowPoint[] }
export type Customer = { id: string; name: string; email: string; currency: string; paymentTerms: string }
export type Invoice = { id: string; customerName: string; invoiceNumber: string; amount: number; issueDate: string; dueDate: string; status: string }
export type Bill = { id: string; vendor: string; billNumber: string; amount: number; dueDate: string; paid: boolean }
export type BankTransaction = { id: string; account: string; date: string; amount: number; type: 'DEBIT'|'CREDIT'; category: string }
export type Expense = { id: string; merchant: string; amount: number; date: string; category: string; status: 'SUBMITTED'|'APPROVED'|'REIMBURSED' }
