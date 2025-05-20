import Image from "next/image";
import { Geist, Geist_Mono } from "next/font/google";

export default function Home() {

  return (
    <>
      <div className="grid grid-cols-5 gap-4 w-9/10 place-items-center">
        <div className="col-span-1">
          Quoties
        </div>
        <div></div>
        <div className="flex gap-40 items-center justify-center">

          <div className="whitespace-nowrap">
            Random Pick
          </div>
          <div>
            <button className="p-1 rounded hover:scale-125 transition-transform">
            <Image src="/item_box.webp" alt="Beispiel" width={70} height={70} />
            </button>
          </div>

        </div>  


        <div className="flex justify-end">
          
        </div>
        
        <div></div>
    
      </div>
    </>
    
  );
}
