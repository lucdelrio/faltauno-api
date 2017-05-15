package ar.api.faltauno.servicios;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.api.faltauno.modelo.Match;

@Service("matchService")
@Transactional
public class MatchServiceImpl implements MatchService{
	
    private static final AtomicInteger counter = new AtomicInteger();
    
    private static List<Match> matches;
      
	@Override
	public Match findById(int matchId) {
		for(Match match : matches){
            if(match.getMatchId() == matchId){
                return match;
            }
        }
        return null;
	}
	
    /*@Override
     * public Match findByName(String name) {
    	for(Match match : matches){
        	if(match.getName().equalsIgnoreCase(name)){
            	return match;
        	}
    	}
    	return null;
	}*/

	@Override
	public void saveMatch(Match match) {

		match.setMatchId(counter.incrementAndGet());
        matches.add(match);	
	}

	@Override
	public void updateMatch(Match match) {
        int index = matches.indexOf(match);
        matches.set(index, match);		
	}

	@Override
	public void deleteMatchById(int matchId) {
        
       for (Iterator<Match> iterator = matches.iterator(); iterator.hasNext(); ) {
           Match match = iterator.next();
           if (match.getMatchId() == matchId) {
               iterator.remove();
           }
       }		
	}

	@Override
    public List<Match> findAllMatches() {
        return matches;
    }

	@Override
	public boolean isMatchExist(Match match) {
        return findById(match.getMatchId())!=null;
	}
 
}
