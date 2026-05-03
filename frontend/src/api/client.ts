const baseUrl=import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080/api';
async function req<T>(path:string, init?:RequestInit):Promise<T>{const res=await fetch(`${baseUrl}${path}`,{...init,headers:{'content-type':'application/json','X-Org-Id':'demo-org',...(init?.headers||{})}}); if(!res.ok) throw new Error(await res.text()); return res.json() as Promise<T>}
export const api={get:<T>(path:string)=>req<T>(path),post:<T>(path:string,body:unknown)=>req<T>(path,{method:'POST',body:JSON.stringify(body)})}
