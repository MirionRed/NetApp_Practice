use Net::DNS;
use Data::Dumper;

my $res = Net::DNS::Resolver->new(
  nameservers => [qw(8.8.8.8), qw(8.8.4.4)]
);

my $domain = "www.google.com";
my $query = $res->search($domain);

if($query){
  foreach my $rr ($query->answer){
    print Dumper($rr->type);
    next unless $rr->type eq "A";
    $address = $rr->address;
    print "Domain: $domain\n";
    print "IP Address: $address\n";
  }
}else{
  print "No name resolution found.\n";
}
