package Tests.FreshService;

import java.util.concurrent.ConcurrentHashMap;

// Fresh is a system at Grindr for helping users find each other. For example, when a user uploads a photo, an event is
// emitted and processed by the fresh service. The isFresh() method is called at a high frequency and returns a boolean
// true if the user is fresh.
//
// Implement the FreshService with the following requirements:
// * A photo upload event triggers the user to be fresh for one hour
// * Additional photo upload events are ignored if the user is already fresh
// * Users can only be fresh once within 24 hours
class FreshService {
    private static final long ONE_HOUR = 3600000L;
    private final ConcurrentHashMap<Long, Long> ownEvent;

    public FreshService(ConcurrentHashMap<Long, Long> ownEvent) {
        this.ownEvent = ownEvent;
    }

    public void process(PhotoUploadEvent event) {
        // TODO: implement
        if(ownEvent.contains(event.profileId)) {
            if(System.currentTimeMillis() >= (ownEvent.get(event.profileId) + 23 * ONE_HOUR))
                ownEvent.put(event.profileId, event.timestamp + ONE_HOUR);
        } else {
            ownEvent.put(event.profileId, event.timestamp + ONE_HOUR);
        }
    }

    public boolean isFresh(Long profileId) {
        // TODO: implement
        if(ownEvent.contains(profileId)) {
            return System.currentTimeMillis() < ownEvent.get(profileId);
        }
        return false;
    }
}

class PhotoUploadEvent {
    public Long profileId;
    public Long timestamp;

    public PhotoUploadEvent(Long profileId, Long timestamp) {
        this.profileId = profileId;
        this.timestamp = timestamp;
    }
}

