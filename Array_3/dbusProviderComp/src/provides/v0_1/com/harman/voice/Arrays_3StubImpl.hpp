/**
 * generated by Voice CodeGen Version: Beta_R1_v0.1.0
 * generated on: Thu Sep 10 18:55:36 IST 2015
 */

#ifndef V0_1_COM_HARMAN_VOICE_ARRAYS_3STUBIMPL_HPP
#define V0_1_COM_HARMAN_VOICE_ARRAYS_3STUBIMPL_HPP

#include <CommonAPI/CommonAPI.hpp>
#include "v0_1/com/harman/voice/Arrays_3StubDefault.hpp"

namespace v0_1 {
namespace com {
namespace harman {
namespace voice {

class Arrays_3StubImpl : public v0_1::com::harman::voice::Arrays_3StubDefault
{

public:
	Arrays_3StubImpl();
    virtual ~Arrays_3StubImpl();

	virtual void route(const std::shared_ptr<CommonAPI::ClientId> _client, std::vector<::v0_1::com::harman::voice::Arrays_3::latlong> latLong, routeReply_t);
	virtual void getShortestRoute(const std::shared_ptr<CommonAPI::ClientId> _client, ::v0_1::com::harman::voice::Arrays_3::latlong latLongStructure, getShortestRouteReply_t);
	virtual void getPOI(const std::shared_ptr<CommonAPI::ClientId> _client, ::v0_1::com::harman::voice::Arrays_3::latlong latLongStruct, getPOIReply_t);
};

} // namespace voice
} // namespace harman
} // namespace com
} // namespace v0_1

#endif //V0_1_COM_HARMAN_VOICE_ARRAYS_3STUBIMPL_HPP
