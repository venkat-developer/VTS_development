/**
 * generated by Voice CodeGen Version: Beta_R1_v0.1.0
 * generated on: Thu Sep 10 18:55:36 IST 2015
 */

#include <thread>

#include <CommonAPI/CommonAPI.hpp>
#include "v0_1/com/harman/voice/Arrays_3.hpp"
#include "v0_1/com/harman/voice/Arrays_3Proxy.hpp"

int main(int argc, char **argv) {
	CommonAPI::Runtime::setProperty("LogContext", "tesseractConsumerComp");
	CommonAPI::Runtime::setProperty("LibraryBase", "tesseractConsumerComp");

	/*
	 * create the runtime
	 */
	std::shared_ptr<CommonAPI::Runtime> runtime = CommonAPI::Runtime::get();
	if(!runtime)
	{
		// Error: could not load runtime
		return 1;
	}
	
	std::string domain = "local";
    
    
    // create the Arrays_3 proxy
    {
    	std::string connection = "tesseractProviderComp";
    	std::string instance = "tesseractProviderComp.tesseractProviderCompInstance";
    	std::shared_ptr<v0_1::com::harman::voice::Arrays_3Proxy<>> proxyInst = runtime->buildProxy<v0_1::com::harman::voice::Arrays_3Proxy>(domain, instance, connection);
    	if(!proxyInst)
    	{
    		// Error: could not create Arrays_3Proxy
    	}
    }
    
    while (true) {
        std::cout << "Waiting for calls... (Abort with CTRL+C)" << std::endl;
        std::this_thread::sleep_for(std::chrono::seconds(60));
    }
    return 0;
}
