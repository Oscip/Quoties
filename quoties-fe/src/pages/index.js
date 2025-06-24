import Image from "next/image";
import { Jacques_Francois } from "next/font/google";
import { useState } from "react";

const jacquesFrancois = Jacques_Francois({
  subsets: ["latin"],
  weight: "400",
});

export default function Home() {
  const [loading, setLoading] = useState(false);
  const [fetchedData, setFetchedData] = useState(null);

  const fetchData = async () => {
    try {
      setLoading(true);

      const audio = new Audio("/item_box.mp3");
      audio.play();

      const response = await fetch("http://localhost:8080/api/quotes/new", {
        method: "GET",
      });

      if (response.ok) {
        const data = await response.json();
        await new Promise((resolve) => setTimeout(resolve, 5000));
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
    <div className="relative m-4 sm:m-10">
      <div className="grid grid-cols-1 sm:grid-cols-5 gap-4 w-full place-items-center">
        <div className={`${jacquesFrancois.className} text-3xl sm:text-5xl`}>
          Quoties
        </div>

        {/* Gemeinsamer Container für Random Pick + Button */}
        <div className="sm:col-span-3 flex flex-col sm:flex-row items-center sm:justify-center gap-4 w-full">
          <div className="p-4 bg-gray-500 w-64 text-white rounded-2xl text-xl sm:text-2xl text-center">
            Random Pick
          </div>

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
      </div>

      <div className="mt-8 w-full flex flex-col items-center">
        <div className="w-full max-w-3xl">
          <div className="text-3xl sm:text-5xl font-sans font-semibold">
            Deutsch
          </div>
          <div className="mt-4 bg-gray-500 w-full text-white rounded-2xl text-base sm:text-lg p-6 min-h-[12rem] break-words">
            <div className="flex justify-between text-2xl sm:text-3xl">
              <div>{fetchedData?.wordTranslated ?? "Wort"}</div>
              {fetchedData && (
                <div className="text-right text-sm sm:text-base">
                  UrbanDictionary
                </div>
              )}
            </div>
            <div className="mt-4">
              {fetchedData?.definitionTranslated ?? "Erklärung"}
            </div>
          </div>
          <div className="mt-4 bg-gray-500 w-full text-white rounded-2xl text-base sm:text-lg p-6 break-words">
            {fetchedData?.quoteTranslated ?? "Zitat"}
          </div>
        </div>

        <div className="w-full max-w-3xl mt-12">
          <div className="text-3xl sm:text-5xl font-sans font-semibold">
            English
          </div>
          <div className="mt-4 bg-gray-500 w-full text-white rounded-2xl text-base sm:text-lg p-6 min-h-[12rem] break-words">
            <div className="flex justify-between text-2xl sm:text-3xl">
              <div>{fetchedData?.word ?? "Word"}</div>
              {fetchedData && (
                <div className="text-right text-sm sm:text-base">
                  UrbanDictionary
                </div>
              )}
            </div>
            <div className="mt-4">
              {fetchedData?.definition ?? "Definition"}
            </div>
          </div>

          <div className="mt-4 bg-gray-500 w-full text-white rounded-2xl text-base sm:text-lg p-6 break-words">
            {fetchedData?.quote ?? "Quote"}
          </div>
        </div>
      </div>

      <div className="absolute bottom right-4">
        <a
          href="https://github.com/Oscip/Quoties"
          target="_blank"
          className="hover:scale-125 transition-transform block"
        >
          <Image
            src="/github-mark.svg"
            width={70}
            height={70}
            alt="GitHub Repo"
          />
        </a>
      </div>
    </div>
  );
}
