import Image from "next/image";
import { Geist, Geist_Mono } from "next/font/google";

export default function Home() {

  return (
    <div className="m-10">

      <div className="grid grid-cols-5 gap-4 w-9/10 place-items-center">
        <div className="col-span-1">
          Quoties
        </div>
        <div></div>
        <div className="flex gap-40 items-center justify-center">

        <div className="whitespace-nowrap p-4  bg-gray-500 w-40 text-white p-2 rounded-2xl text-lg text-center">
          Random Pick
        </div>

          <div>
          <button className="w-20 h-20 rounded hover:scale-125 transition-transform p-2">
            <Image src="/item_box.webp" alt="Beispiel" layout="responsive" width={100} height={100} />
          </button>
          </div>

        </div>  
        
        <div></div>
    
      </div>

    </div>
  );
}
