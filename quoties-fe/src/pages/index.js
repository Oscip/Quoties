import Image from "next/image";
import { Geist, Geist_Mono } from "next/font/google";
import { useState } from "react";

export default function Home() {
  const [loading, setLoading] = useState(false);
  const [fetchedData, setFetchedData] = useState(null);

  // Uncomment when Merge Conflicts in "dev branch are resolved
/*
  const fetchData = async () => {
    try {
      setLoading(true);

      const audio = new Audio('/item_box.mp3');
      audio.play();

      const response = await fetch("http://localhost:8080/wortübersetzt/quote/quotübersetzt/Definition/definitionübersetzt", {
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
*/

  return (
    <div className="m-10">
      <div className="grid grid-cols-5 gap-4 w-9/10 place-items-center">
        <div className="col-span-1">Quoties</div>
        <div></div>
        <div className="flex gap-40 items-center justify-center">
          <div className="whitespace-nowrap p-4 bg-gray-500 w-40 text-white rounded-2xl text-lg text-center">
            Random Pick
          </div>

          <div>
            <button
              className="w-20 h-20 rounded hover:scale-125 transition-transform p-2"
              // onClick={fetchData}
            >
              <Image
                src="/item_box.webp"
                alt="Beispiel"
                layout="responsive"
                width={100}
                height={100}
              />
            </button>
            {loading && <p className="mt-4 text-yellow-500">Lade...</p>}
          </div>
        </div>
        <div></div>
      </div>
    </div>
  );
}