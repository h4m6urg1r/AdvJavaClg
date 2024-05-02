{
	inputs={
		nixpkgs.url = "github:NixOS/nixpkgs/23.05";
	};
	outputs={nixpkgs, ...}@inputs: let
		forAllSystems = nixpkgs.lib.genAttrs [
			"aarch64-linux"
			"i686-linux"
			"x86_64-linux"
			"aarch64-darwin"
			"x86_64-darwin"
		];
		in rec {
			devShells = forAllSystems (system:
				let pkgs = nixpkgs.legacyPackages.${system};
				in import ./shell.nix { inherit pkgs; }
			);
	};
}