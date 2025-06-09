import Image from "next/image";
import { Jacques_Francois } from "next/font/google";
import { useState } from "react";

const jacquesFrancois = Jacques_Francois({
  subsets: ["latin"],
  weight: "400", // nur Regular verfügbar
});

export default function Home() {
  const [loading, setLoading] = useState(false);
  const [fetchedData, setFetchedData] = useState(null);

  const fetchData = async () => {
    try {
      setLoading(true);

      const audio = new Audio('/item_box.mp3');
      audio.play();

      const response = await fetch("http://localhost:8080/api/quotes/new", {
      method: "GET",
      });

      if (response.ok) {
        const data = await response.json();
        await new Promise(resolve => setTimeout(resolve, 5000));
        setFetchedData(data);
      } else {
        console.error("Error loading data:", response.status);
      }

    } catch (error) {
      console.error("Error fetching data:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
<div className="m-10">
  <div className="grid grid-cols-5 gap-4 w-full place-items-center">
    <div className={`${jacquesFrancois.className} col-span-1 text-5xl`}>Quoties</div>
    
    <div>
      <div className="whitespace-nowrap p-4 bg-gray-500 w-64 text-white rounded-2xl text-2xl text-center">
        Random Pick
      </div>
    </div>

    <div>
      <button
        className="w-20 h-20 rounded hover:scale-125 transition-transform p-2"
        onClick={fetchData}
      >
        <Image
          src="/item_box.webp"
          alt="Beispiel"
          layout="responsive"
          width={100}
          height={100}
        />
      </button>
      {loading && <p className="mt-4">Lade...</p>}
    </div>

    <div></div> 
    <div></div> 
  </div>
  <br/>

<div className="grid grid-cols-4 gap-4 w-full place-items-center mt-4">
  <div></div> 
  
  <div className="col-span-2 w-full"> 
    <div className="text-5xl font-sans font-semibold">Deutsch</div>
    <br/>
    <div className="whitespace-nowrap p-4 bg-gray-500 w-full text-white rounded-2xl text-lg h-48 p-7">
      <div className="grid grid-flow-col">
        <div className="text-4xl">
          {fetchedData?.wordTranslated ?? 'Wort'}
        </div>
        <div className="flex justify-end">
          {fetchedData && <p>UrbanDictionary</p>}
        </div>
      </div>
      <br/>
      <div className="grid grid-flow-col">
        <div>
          {fetchedData?.definitionTranslated ?? 'Erklärung'}
        </div>
      </div>
    </div>
  </div>

  <div></div>
</div>

<div className="grid grid-cols-4 gap-4 w-full place-items-center mt-4">
  <div></div> 
  
  <div className="col-span-2 w-full"> 
    <br/>
    <div className="whitespace-nowrap p-4 bg-gray-500 w-full text-white rounded-2xl text-lg h-auto p-7 text-wrap">
      <div className="text-wrap">
          {fetchedData?.quoteTranslated ?? 'Zitat'}
      </div>
    </div>
  </div>

  <div></div>
</div>

</div>
  );
}